/*
 * Copyright (c) 2015-2022 Snowplow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */

package com.snowplowanalytics.snowplow.event;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.snowplowanalytics.core.tracker.Tracker;
import com.snowplowanalytics.core.constants.Parameters;
import com.snowplowanalytics.core.constants.TrackerConstants;
import com.snowplowanalytics.snowplow.payload.SelfDescribingJson;
import com.snowplowanalytics.core.utils.Preconditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/** A consent granted event. */
public class ConsentGranted extends AbstractSelfDescribing {

    /** Expiration of the consent. */
    @NonNull
    public final String expiry;
    /** Identifier of the first document. */
    @NonNull
    public final String documentId;
    /** Version of the first document. */
    @NonNull
    public final String documentVersion;
    /** Name of the first document. */
    @Nullable
    public String documentName;
    /** Description of the first document. */
    @Nullable
    public String documentDescription;
    /** Other attached documents. */
    @NonNull
    public final List<ConsentDocument> consentDocuments = new LinkedList<>();

    /**
     Creates a consent granted event with a first document.
     @param expiry Consent expiration.
     @param documentId Identifier of the first document.
     @param documentVersion Version of the first document.
     */
    public ConsentGranted(@NonNull String expiry, @NonNull String documentId, @NonNull String documentVersion) {
        Preconditions.checkNotNull(expiry);
        Preconditions.checkArgument(!expiry.isEmpty(), "Expiry cannot be empty");
        Preconditions.checkNotNull(documentId);
        Preconditions.checkArgument(!documentId.isEmpty(), "Document ID cannot be empty");
        Preconditions.checkNotNull(documentVersion);
        Preconditions.checkArgument(!documentVersion.isEmpty(), "Document version cannot be empty");
        this.expiry = expiry;
        this.documentId = documentId;
        this.documentVersion = documentVersion;
    }

    // Builder methods

    /** Name of the first document. */
    @NonNull
    public ConsentGranted documentName(@Nullable String documentName) {
        this.documentName = documentName;
        return this;
    }

    /** Description of the first document. */
    @NonNull
    public ConsentGranted documentDescription(@Nullable String documentDescription) {
        this.documentDescription = documentDescription;
        return this;
    }

    /** Other attached documents. */
    @NonNull
    public ConsentGranted documents(@NonNull List<ConsentDocument> documents) {
        consentDocuments.clear();
        consentDocuments.addAll(documents);
        return this;
    }

    // Public methods

    /** Returns a list of consent documents associated with the event. */
    public @NonNull List<ConsentDocument> getDocuments() {
        List<ConsentDocument> docs = new ArrayList<>();
        ConsentDocument doc = new ConsentDocument(documentId, documentVersion)
                .documentDescription(documentDescription)
                .documentName(documentName);
        docs.add(doc);
        docs.addAll(consentDocuments);
        return docs;
    }

    // Tracker methods

    @Override
    public @NonNull Map<String, Object> getDataPayload() {
        HashMap<String,Object> payload = new HashMap<>();
        payload.put(Parameters.CG_EXPIRY, expiry);
        return payload;
    }

    @Override
    public @NonNull String getSchema() {
        return TrackerConstants.SCHEMA_CONSENT_GRANTED;
    }

    @Override
    public void beginProcessing(@NonNull Tracker tracker) {
        for (ConsentDocument document : getDocuments()) {
            SelfDescribingJson context = new SelfDescribingJson(document.getSchema(), document.getDataPayload());
            customContexts.add(context);  // TODO: Only the user should modify the public customContexts property
        }
    }
}

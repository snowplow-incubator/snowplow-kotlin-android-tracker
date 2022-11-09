package com.snowplowanalytics.snowplow.configuration

import com.snowplowanalytics.core.tracker.Logger
import com.snowplowanalytics.core.tracker.TrackerConfigurationInterface
import com.snowplowanalytics.snowplow.configuration.TrackerConfiguration
import com.snowplowanalytics.snowplow.tracker.DevicePlatform
import com.snowplowanalytics.snowplow.tracker.LogLevel
import com.snowplowanalytics.snowplow.tracker.LoggerDelegate
import org.json.JSONObject
import java.util.*

/**
 * This class represents the configuration of the tracker and the core tracker properties.
 * The TrackerConfiguration can be used to setup the tracker behaviour indicating what should be
 * tracked in term of automatic tracking and contexts/entities to track with the events.
 */
open class TrackerConfiguration(
    /**
     * @see .appId
     */
    var appId: String
) : TrackerConfigurationInterface, Configuration {
    /**
     * @see .devicePlatform
     */
    var devicePlatform: DevicePlatform

    /**
     * @see .base64encoding
     */
    var base64encoding: Boolean

    /**
     * @see .logLevel
     */
    var logLevel: LogLevel

    /**
     * @see .loggerDelegate
     */
    var loggerDelegate: LoggerDelegate?

    /**
     * @see .applicationContext
     */
    var applicationContext: Boolean

    /**
     * @see .platformContext
     */
    var platformContext: Boolean

    /**
     * @see .geoLocationContext
     */
    var geoLocationContext: Boolean

    /**
     * @see .sessionContext
     */
    var sessionContext: Boolean

    /**
     * @see .deepLinkContext
     */
    var deepLinkContext: Boolean

    /**
     * @see .screenContext
     */
    var screenContext: Boolean

    /**
     * @see .screenViewAutotracking
     */
    var screenViewAutotracking: Boolean

    /**
     * @see .lifecycleAutotracking
     */
    var lifecycleAutotracking: Boolean

    /**
     * @see .installAutotracking
     */
    var installAutotracking: Boolean

    /**
     * @see .exceptionAutotracking
     */
    var exceptionAutotracking: Boolean

    /**
     * @see .diagnosticAutotracking
     */
    var diagnosticAutotracking: Boolean

    /**
     * @see .userAnonymisation
     */
    var userAnonymisation: Boolean

    /**
     * @see .trackerVersionSuffix
     */
    var trackerVersionSuffix: String? = null

    // Getters and Setters
    override fun getAppId(): String {
        return appId
    }

    override fun setAppId(appId: String) {
        this.appId = appId
    }

    override fun getDevicePlatform(): DevicePlatform {
        return devicePlatform
    }

    override fun setDevicePlatform(devicePlatform: DevicePlatform) {
        this.devicePlatform = devicePlatform
    }

    override fun isBase64encoding(): Boolean {
        return base64encoding
    }

    override fun setBase64encoding(base64encoding: Boolean) {
        this.base64encoding = base64encoding
    }

    override fun getLogLevel(): LogLevel {
        return logLevel
    }

    override fun setLogLevel(logLevel: LogLevel) {
        this.logLevel = logLevel
    }

    override fun getLoggerDelegate(): LoggerDelegate? {
        return loggerDelegate
    }

    override fun setLoggerDelegate(loggerDelegate: LoggerDelegate?) {
        this.loggerDelegate = loggerDelegate
    }

    override fun isApplicationContext(): Boolean {
        return applicationContext
    }

    override fun setApplicationContext(applicationContext: Boolean) {
        this.applicationContext = applicationContext
    }

    override fun isPlatformContext(): Boolean {
        return platformContext
    }

    override fun setPlatformContext(platformContext: Boolean) {
        this.platformContext = platformContext
    }

    override fun isGeoLocationContext(): Boolean {
        return geoLocationContext
    }

    override fun setGeoLocationContext(geoLocationContext: Boolean) {
        this.geoLocationContext = geoLocationContext
    }

    override fun isSessionContext(): Boolean {
        return sessionContext
    }

    override fun setSessionContext(sessionContext: Boolean) {
        this.sessionContext = sessionContext
    }

    override fun isDeepLinkContext(): Boolean {
        return deepLinkContext
    }

    override fun setDeepLinkContext(deepLinkContext: Boolean) {
        this.deepLinkContext = deepLinkContext
    }

    override fun isScreenContext(): Boolean {
        return screenContext
    }

    override fun setScreenContext(screenContext: Boolean) {
        this.screenContext = screenContext
    }

    override fun isScreenViewAutotracking(): Boolean {
        return screenViewAutotracking
    }

    override fun setScreenViewAutotracking(screenViewAutotracking: Boolean) {
        this.screenViewAutotracking = screenViewAutotracking
    }

    override fun isLifecycleAutotracking(): Boolean {
        return lifecycleAutotracking
    }

    override fun setLifecycleAutotracking(lifecycleAutotracking: Boolean) {
        this.lifecycleAutotracking = lifecycleAutotracking
    }

    override fun isInstallAutotracking(): Boolean {
        return installAutotracking
    }

    override fun setInstallAutotracking(installAutotracking: Boolean) {
        this.installAutotracking = installAutotracking
    }

    override fun isExceptionAutotracking(): Boolean {
        return exceptionAutotracking
    }

    override fun setExceptionAutotracking(exceptionAutotracking: Boolean) {
        this.exceptionAutotracking = exceptionAutotracking
    }

    override fun isDiagnosticAutotracking(): Boolean {
        return diagnosticAutotracking
    }

    override fun setDiagnosticAutotracking(diagnosticAutotracking: Boolean) {
        this.diagnosticAutotracking = diagnosticAutotracking
    }

    override fun isUserAnonymisation(): Boolean {
        return userAnonymisation
    }

    override fun setUserAnonymisation(userAnonymisation: Boolean) {
        this.userAnonymisation = userAnonymisation
    }

    override fun getTrackerVersionSuffix(): String? {
        return trackerVersionSuffix
    }

    override fun setTrackerVersionSuffix(trackerVersionSuffix: String?) {
        this.trackerVersionSuffix = trackerVersionSuffix
    }
    // Constructors
    /**
     * It sets a default TrackerConfiguration.
     * Default values:
     * devicePlatform = DevicePlatform.Mobile;
     * base64encoding = true;
     * logLevel = LogLevel.OFF;
     * loggerDelegate = null;
     * sessionContext = true;
     * applicationContext = true;
     * platformContext = true;
     * geoLocationContext = false;
     * screenContext = true;
     * deepLinkContext = true;
     * screenViewAutotracking = true;
     * lifecycleAutotracking = false;
     * installAutotracking = true;
     * exceptionAutotracking = true;
     * diagnosticAutotracking = false;
     * userAnonymisation = false;
     * @param appId Identifier of the app.
     */
    init {
        devicePlatform = DevicePlatform.Mobile
        base64encoding = true
        logLevel = LogLevel.OFF
        loggerDelegate = null
        sessionContext = true
        applicationContext = true
        platformContext = true
        geoLocationContext = false
        deepLinkContext = true
        screenContext = true
        screenViewAutotracking = true
        lifecycleAutotracking = false
        installAutotracking = true
        exceptionAutotracking = true
        diagnosticAutotracking = false
        userAnonymisation = false
    }
    // Builder methods
    /**
     * Identifer of the app.
     */
    fun appId(appId: String): TrackerConfiguration {
        this.appId = appId
        return this
    }

    /**
     * It sets the device platform the tracker is running on.
     */
    fun devicePlatform(devicePlatform: DevicePlatform): TrackerConfiguration {
        this.devicePlatform = devicePlatform
        return this
    }

    /**
     * It indicates whether the JSON data in the payload should be base64 encoded.
     */
    fun base64encoding(base64encoding: Boolean): TrackerConfiguration {
        this.base64encoding = base64encoding
        return this
    }

    /**
     * It sets the log level of tracker logs.
     */
    fun logLevel(logLevel: LogLevel): TrackerConfiguration {
        this.logLevel = logLevel
        return this
    }

    /**
     * It sets the logger delegate that receive logs from the tracker.
     */
    fun loggerDelegate(loggerDelegate: LoggerDelegate?): TrackerConfiguration {
        this.loggerDelegate = loggerDelegate
        return this
    }

    /**
     * Whether application context is sent with all the tracked events.
     */
    fun applicationContext(applicationContext: Boolean): TrackerConfiguration {
        this.applicationContext = applicationContext
        return this
    }

    /**
     * Whether mobile/platform context is sent with all the tracked events.
     */
    fun platformContext(platformContext: Boolean): TrackerConfiguration {
        this.platformContext = platformContext
        return this
    }

    /**
     * Whether geo-location context is sent with all the tracked events.
     *
     * @apiNote Requires Location permissions as per the requirements of the various
     * Android versions. Otherwise the whole context is skipped.
     */
    fun geoLocationContext(geoLocationContext: Boolean): TrackerConfiguration {
        this.geoLocationContext = geoLocationContext
        return this
    }

    /**
     * Whether session context is sent with all the tracked events.
     */
    fun sessionContext(sessionContext: Boolean): TrackerConfiguration {
        this.sessionContext = sessionContext
        return this
    }

    /**
     * Whether deepLink context is sent with all the ScreenView events.
     */
    fun deepLinkContext(deepLinkContext: Boolean): TrackerConfiguration {
        this.deepLinkContext = deepLinkContext
        return this
    }

    /**
     * Whether screen context is sent with all the tracked events.
     */
    fun screenContext(screenContext: Boolean): TrackerConfiguration {
        this.screenContext = screenContext
        return this
    }

    /**
     * Whether enable automatic tracking of ScreenView events.
     */
    fun screenViewAutotracking(screenViewAutotracking: Boolean): TrackerConfiguration {
        this.screenViewAutotracking = screenViewAutotracking
        return this
    }

    /**
     * Whether enable automatic tracking of background and foreground transitions.
     * @apiNote It needs the Foreground library installed.
     */
    fun lifecycleAutotracking(lifecycleAutotracking: Boolean): TrackerConfiguration {
        this.lifecycleAutotracking = lifecycleAutotracking
        return this
    }

    /**
     * Whether enable automatic tracking of install event.
     */
    fun installAutotracking(installAutotracking: Boolean): TrackerConfiguration {
        this.installAutotracking = installAutotracking
        return this
    }

    /**
     * Whether enable crash reporting.
     */
    fun exceptionAutotracking(exceptionAutotracking: Boolean): TrackerConfiguration {
        this.exceptionAutotracking = exceptionAutotracking
        return this
    }

    /**
     * Whether enable diagnostic reporting.
     */
    fun diagnosticAutotracking(diagnosticAutotracking: Boolean): TrackerConfiguration {
        this.diagnosticAutotracking = diagnosticAutotracking
        return this
    }

    /**
     * Whether to anonymise client-side user identifiers in session and platform context entities
     */
    fun userAnonymisation(userAnonymisation: Boolean): TrackerConfiguration {
        this.userAnonymisation = userAnonymisation
        return this
    }

    /**
     * Decorate the v_tracker field in the tracker protocol.
     * @note Do not use. Internal use only.
     */
    fun trackerVersionSuffix(trackerVersionSuffix: String?): TrackerConfiguration {
        this.trackerVersionSuffix = trackerVersionSuffix
        return this
    }

    // Copyable
    override fun copy(): Configuration {
        val copy = TrackerConfiguration(appId)
        copy.devicePlatform = devicePlatform
        copy.base64encoding = base64encoding
        copy.logLevel = logLevel
        copy.loggerDelegate = loggerDelegate
        copy.sessionContext = sessionContext
        copy.applicationContext = applicationContext
        copy.platformContext = platformContext
        copy.geoLocationContext = geoLocationContext
        copy.screenContext = screenContext
        copy.deepLinkContext = deepLinkContext
        copy.screenViewAutotracking = screenViewAutotracking
        copy.lifecycleAutotracking = lifecycleAutotracking
        copy.installAutotracking = installAutotracking
        copy.exceptionAutotracking = exceptionAutotracking
        copy.diagnosticAutotracking = diagnosticAutotracking
        copy.userAnonymisation = userAnonymisation
        copy.trackerVersionSuffix = trackerVersionSuffix
        return copy
    }

    // JSON Formatter
    constructor(appId: String, jsonObject: JSONObject) : this(
        jsonObject.optString(
            "appId",
            appId
        )
    ) {
        val `val` = jsonObject.optString("devicePlatform", DevicePlatform.Mobile.value)
        devicePlatform = DevicePlatform.getByValue(`val`)
        base64encoding = jsonObject.optBoolean("base64encoding", base64encoding)
        val log = jsonObject.optString("logLevel", LogLevel.OFF.name)
        try {
            logLevel = LogLevel.valueOf(log.uppercase(Locale.getDefault()))
        } catch (e: Exception) {
            Logger.e(TAG, "Unable to decode `logLevel from remote configuration.")
        }
        sessionContext = jsonObject.optBoolean("sessionContext", sessionContext)
        applicationContext = jsonObject.optBoolean("applicationContext", applicationContext)
        platformContext = jsonObject.optBoolean("platformContext", platformContext)
        geoLocationContext = jsonObject.optBoolean("geoLocationContext", geoLocationContext)
        screenContext = jsonObject.optBoolean("screenContext", screenContext)
        deepLinkContext = jsonObject.optBoolean("deepLinkContext", deepLinkContext)
        screenViewAutotracking =
            jsonObject.optBoolean("screenViewAutotracking", screenViewAutotracking)
        lifecycleAutotracking =
            jsonObject.optBoolean("lifecycleAutotracking", lifecycleAutotracking)
        installAutotracking = jsonObject.optBoolean("installAutotracking", installAutotracking)
        exceptionAutotracking =
            jsonObject.optBoolean("exceptionAutotracking", exceptionAutotracking)
        diagnosticAutotracking =
            jsonObject.optBoolean("diagnosticAutotracking", diagnosticAutotracking)
        userAnonymisation = jsonObject.optBoolean("userAnonymisation", userAnonymisation)
    }

    companion object {
        @JvmField
        val TAG = TrackerConfiguration::class.java.simpleName
    }
}

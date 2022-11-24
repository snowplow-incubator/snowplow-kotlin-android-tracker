package com.snowplowanalytics.snowplow.configuration

import com.snowplowanalytics.core.tracker.SubjectConfigurationInterface
import com.snowplowanalytics.snowplow.util.Size
import org.json.JSONObject

/**
 * This class represents the configuration of the subject.
 * The SubjectConfiguration can be used to setup the tracker with the basic information about the
 * user and the app which will be attached on all the events as contexts.
 * The contexts to track can be enabled in the [TrackerConfiguration] class.
 */
open class SubjectConfiguration() : Configuration, SubjectConfigurationInterface {
    /**
     * @see .userId
     */
    @JvmField
    var userId: String? = null

    /**
     * @see .networkUserId
     */
    @JvmField
    var networkUserId: String? = null

    /**
     * @see .domainUserId
     */
    @JvmField
    var domainUserId: String? = null

    /**
     * @see .useragent
     */
    @JvmField
    var useragent: String? = null

    /**
     * @see .ipAddress
     */
    @JvmField
    var ipAddress: String? = null

    /**
     * @see .timezone
     */
    @JvmField
    var timezone: String? = null

    /**
     * @see .language
     */
    @JvmField
    var language: String? = null

    /**
     * @see .screenResolution
     */
    @JvmField
    var screenResolution: Size? = null

    /**
     * @see .screenViewPort
     */
    @JvmField
    var screenViewPort: Size? = null

    /**
     * @see .colorDepth
     */
    @JvmField
    var colorDepth: Int? = null
    
    // Builder methods
    
    /**
     * The custom UserID.
     */
    fun userId(userId: String?): SubjectConfiguration {
        this.userId = userId
        return this
    }

    /**
     * The network UserID.
     * @apiNote It's not generated by the tracker, it needs to be filled by the developer when instrumenting the tracker.
     */
    fun networkUserId(networkUserId: String?): SubjectConfiguration {
        this.networkUserId = networkUserId
        return this
    }

    /**
     * The domain UserID.
     * @apiNote It's not generated by the tracker, it needs to be filled by the developer when instrumenting the tracker.
     */
    fun domainUserId(domainUserId: String?): SubjectConfiguration {
        this.domainUserId = domainUserId
        return this
    }

    /**
     * The user-agent.
     * @apiNote It's not generated by the tracker, it needs to be filled by the developer when instrumenting the tracker.
     */
    fun useragent(useragent: String?): SubjectConfiguration {
        this.useragent = useragent
        return this
    }

    /**
     * The IP address.
     * @apiNote It's not generated by the tracker, it needs to be filled by the developer when instrumenting the tracker.
     */
    fun ipAddress(ipAddress: String?): SubjectConfiguration {
        this.ipAddress = ipAddress
        return this
    }

    /**
     * The current timezone.
     */
    fun timezone(timezone: String?): SubjectConfiguration {
        this.timezone = timezone
        return this
    }

    /**
     * The language set in the device.
     */
    fun language(language: String?): SubjectConfiguration {
        this.language = language
        return this
    }

    /**
     * The screen resolution.
     */
    fun screenResolution(screenResolution: Size?): SubjectConfiguration {
        this.screenResolution = screenResolution
        return this
    }

    /**
     * The screen viewport.
     * @apiNote It's not generated by the tracker, it needs to be filled by the developer when instrumenting the tracker.
     */
    fun screenViewPort(screenViewPort: Size?): SubjectConfiguration {
        this.screenViewPort = screenViewPort
        return this
    }

    /**
     * The color depth.
     * @apiNote It's not generated by the tracker, it needs to be filled by the developer when instrumenting the tracker.
     */
    fun colorDepth(colorDepth: Int?): SubjectConfiguration {
        this.colorDepth = colorDepth
        return this
    }

    // Getters and Setters
    override fun getUserId(): String? {
        return userId
    }

    override fun setUserId(userId: String?) {
        this.userId = userId
    }

    override fun getNetworkUserId(): String? {
        return networkUserId
    }

    override fun setNetworkUserId(networkUserId: String?) {
        this.networkUserId = networkUserId
    }

    override fun getDomainUserId(): String? {
        return domainUserId
    }

    override fun setDomainUserId(domainUserId: String?) {
        this.domainUserId = domainUserId
    }

    override fun getUseragent(): String? {
        return useragent
    }

    override fun setUseragent(useragent: String?) {
        this.useragent = useragent
    }

    override fun getIpAddress(): String? {
        return ipAddress
    }

    override fun setIpAddress(ipAddress: String?) {
        this.ipAddress = ipAddress
    }

    override fun getTimezone(): String? {
        return timezone
    }

    override fun setTimezone(timezone: String?) {
        this.timezone = timezone
    }

    override fun getLanguage(): String? {
        return language
    }

    override fun setLanguage(language: String?) {
        this.language = language
    }

    override fun getScreenResolution(): Size? {
        return screenResolution
    }

    override fun setScreenResolution(screenResolution: Size?) {
        this.screenResolution = screenResolution
    }

    override fun getScreenViewPort(): Size? {
        return screenViewPort
    }

    override fun setScreenViewPort(screenViewPort: Size?) {
        this.screenViewPort = screenViewPort
    }

    override fun getColorDepth(): Int? {
        return colorDepth
    }

    override fun setColorDepth(colorDepth: Int?) {
        this.colorDepth = colorDepth
    }

    // Copyable
    override fun copy(): SubjectConfiguration {
        return SubjectConfiguration()
            .userId(userId)
            .networkUserId(networkUserId)
            .domainUserId(domainUserId)
            .useragent(useragent)
            .ipAddress(ipAddress)
            .timezone(timezone)
            .language(language)
            .screenResolution(screenResolution)
            .screenViewPort(screenViewPort)
            .colorDepth(colorDepth)
    }

    // JSON Formatter
    constructor(jsonObject: JSONObject) : this() {
        userId = if (jsonObject.has("userId")) jsonObject.optString("userId") else null
        networkUserId =
            if (jsonObject.has("networkUserId")) jsonObject.optString("networkUserId") else null
        domainUserId =
            if (jsonObject.has("domainUserId")) jsonObject.optString("domainUserId") else null
        useragent = if (jsonObject.has("useragent")) jsonObject.optString("useragent") else null
        ipAddress = if (jsonObject.has("ipAddress")) jsonObject.optString("ipAddress") else null
        timezone = if (jsonObject.has("timezone")) jsonObject.optString("timezone") else null
        language = if (jsonObject.has("language")) jsonObject.optString("language") else null
    }
}

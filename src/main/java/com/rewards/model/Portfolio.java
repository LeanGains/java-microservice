package com.rewards.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a customer's portfolio of channel subscriptions.
 */
public class Portfolio {
    private final Set<Channel> channelSubscriptions;
    
    /**
     * Creates a new Portfolio with the given channel subscriptions.
     * 
     * @param channelSubscriptions The set of subscribed channels
     */
    public Portfolio(Set<Channel> channelSubscriptions) {
        this.channelSubscriptions = new HashSet<>(channelSubscriptions);
    }
    
    /**
     * Returns an unmodifiable view of the channel subscriptions.
     * 
     * @return The set of subscribed channels
     */
    public Set<Channel> getChannelSubscriptions() {
        return Collections.unmodifiableSet(channelSubscriptions);
    }
    
    /**
     * Checks if the portfolio contains a specific channel subscription.
     * 
     * @param channel The channel to check for
     * @return true if the channel is subscribed, false otherwise
     */
    public boolean hasChannel(Channel channel) {
        return channelSubscriptions.contains(channel);
    }
}
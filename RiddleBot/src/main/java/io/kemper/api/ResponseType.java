package io.kemper.api;

/**
 * Slack response type
 *
 * ephemeral is default
 */
//@JsonFormat(shape= JsonFormat.Shape.STRING)
public enum ResponseType {
    in_channel, ephemeral
}

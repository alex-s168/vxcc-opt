package me.alex_s168.me.alex_s168.vxcc.ir.lang

import kotlinx.serialization.Serializable

/**
 * All IR elements are immutable except statements.
 */
@Serializable
sealed interface IRElement {
    fun copyRenamed(transform: (String) -> String): IRElement
}
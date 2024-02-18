package me.alex_s168.me.alex_s168.vxcc.ir.lang

import kotlinx.serialization.Polymorphic
import kotlinx.serialization.Serializable

@Serializable
@Polymorphic
class IRVariableDefinition(
    val name: String?,
    val typ: String,
): IRElement {
    override fun copyRenamed(transform: (String) -> String): IRElement =
        IRVariableDefinition(
            name?.let(transform),
            typ
        )
}
package me.alex_s168.me.alex_s168.vxcc.ir.lang

import kotlinx.serialization.Polymorphic
import kotlinx.serialization.Serializable

@Serializable
@Polymorphic
class IRConstDefinition(
    val name: String,
    val typ: String,
    val value: IRElement,
): IRElement {
    override fun copyRenamed(transform: (String) -> String): IRElement =
        IRConstDefinition(
            transform(name),
            typ,
            value.copyRenamed(transform)
        )
}
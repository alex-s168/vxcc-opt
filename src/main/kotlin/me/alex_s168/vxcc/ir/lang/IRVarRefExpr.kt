package me.alex_s168.me.alex_s168.vxcc.ir.lang

import kotlinx.serialization.Polymorphic
import kotlinx.serialization.Serializable

@Polymorphic
@Serializable
class IRVarRefExpr(
    val name: String,
    val reinterpret: String?,
): IRElement {
    override fun copyRenamed(transform: (String) -> String): IRElement =
        IRVarRefExpr(
            transform(name),
            reinterpret
        )
}
package me.alex_s168.me.alex_s168.vxcc.ir.lang

import kotlinx.serialization.Polymorphic
import kotlinx.serialization.Serializable

@Serializable
@Polymorphic
class IRReturnStmt(
    val value: IRElement?,
): IRElement {
    override fun copyRenamed(transform: (String) -> String): IRElement =
        IRReturnStmt(
            value?.copyRenamed(transform)
        )
}
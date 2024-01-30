package me.alex_s168.me.alex_s168.vxcc.ir.lang

import kotlinx.serialization.Polymorphic
import kotlinx.serialization.Serializable

@Polymorphic
@Serializable
class IRCall(
    val func: IRElement,
    val args: List<IRElement>,
    val resultType: String?,

    val abi: String?,
    val noinline: Boolean,
): IRElement
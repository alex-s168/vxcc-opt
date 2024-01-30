package me.alex_s168.me.alex_s168.vxcc.ir.lang

import kotlinx.serialization.Polymorphic
import kotlinx.serialization.Serializable

@Serializable
@Polymorphic
class IRFunctionDefinition(
    val name: String,

    val args: List<String>,
    val ret: String?,

    val inline: Boolean,
    val extern: Boolean,
    val noinline: Boolean,
    val noreturn: Boolean,
    val pure: Boolean,
    val export: Boolean,

    val abi: String?,
    val section: String?,
    val align: Int,

    val body: IRInstructionBlock?,
): IRElement
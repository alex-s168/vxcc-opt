package me.alex_s168.me.alex_s168.vxcc.ir.opt

import me.alex_s168.me.alex_s168.vxcc.ir.lang.IRInstructionBlock

interface OptPass {
    fun runOnGlobal(block: IRInstructionBlock)
}
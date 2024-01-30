package me.alex_s168.me.alex_s168.vxcc.ir.opt

import me.alex_s168.me.alex_s168.vxcc.ir.lang.IRInstructionBlock
import me.alex_s168.me.alex_s168.vxcc.ir.lang.functions
import me.alex_s168.me.alex_s168.vxcc.ir.lang.willStopFunctionFlow

class RemoveCodeAfterExit: OptPass {
    override fun runOnGlobal(block: IRInstructionBlock) {
        for (function in block.functions()) {
            var remove = false
            function.body?.children?.listIterator()?.let { iter ->
                while (iter.hasNext()) {
                    val element = iter.next()
                    if (remove) {
                        iter.remove()
                    }
                    else if (element.willStopFunctionFlow(function.body)) {
                        remove = true
                    }
                }
            }
        }
    }
}
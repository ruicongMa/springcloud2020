package com.mark.inerpreter.eg;

/**
 * @author Mark
 * @date 2020/5/25 17:26
 */
public class AddInterpreter extends Interpreter {

    public AddInterpreter(IArithmeticlnterpreter left, IArithmeticlnterpreter right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return this.left.interpret() + this.right.interpret();
    }
}

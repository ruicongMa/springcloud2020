package com.mark.inerpreter.eg;

/**
 * @author Mark
 * @date 2020/5/25 17:31
 */
public class DivInterpreter extends Interpreter {

    public DivInterpreter(IArithmeticlnterpreter left, IArithmeticlnterpreter right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return this.left.interpret() / this.right.interpret();
    }
}

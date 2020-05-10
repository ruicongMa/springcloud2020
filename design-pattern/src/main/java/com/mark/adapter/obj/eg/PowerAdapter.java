package com.mark.adapter.obj.eg;

/**
 * @author Mark
 * @date 2020/5/10 12:07
 */
public class PowerAdapter implements DC5 {

    private AC220V ac220V;

    public PowerAdapter(AC220V ac220V) {
        this.ac220V = ac220V;
    }

    @Override
    public int outputDC5V() {
        int outputAC220V = this.ac220V.outputAC220V();
        int adapterOutput = outputAC220V / 44;
        System.out.println("使用 Adapter 输入 AC" + outputAC220V + "V，输出DC：" + adapterOutput + "V");
        return adapterOutput;
    }
}

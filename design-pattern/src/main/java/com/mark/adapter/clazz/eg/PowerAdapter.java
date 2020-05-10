package com.mark.adapter.clazz.eg;

/**
 * @author Mark
 * @date 2020/5/10 12:07
 */
public class PowerAdapter extends AC220V implements DC5 {
    @Override
    public int outputDC5V() {
        int outputAC220V = super.outputAC220V();
        int adapterOutput = outputAC220V / 44;
        System.out.println("使用 Adapter 输入 AC" + outputAC220V + "V，输出DC：" + adapterOutput + "V");
        return adapterOutput;
    }
}

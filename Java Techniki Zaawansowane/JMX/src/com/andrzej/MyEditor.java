package com.andrzej;

public class MyEditor implements MyEditorMBean {
    private String mapping;
    private String swap;

    public MyEditor() {
        mapping = "<MAP>";
        swap = "<SWAP>";
    }

    @Override
    public void setMapping(String text) {
        mapping=text;
    }

    @Override
    public String getMapping() {
        return mapping;
    }

    @Override
    public void setSwap(String swap) {
        this.swap = swap;
    }

    @Override
    public String getSwap() {
        return swap;
    }

    public String calculateText(String text){
        if(text.contains(mapping)){
            System.out.println("Tekst poddano mapowaniu");
            return text.replaceAll(mapping,swap);
        }else{
            System.out.println("Brak mapowania");
            return text;
        }
    }
}

package trabalhointerface.modelo;

public class VendaDTO {
    private int codigo;
    private String data;
    private float total;

    public VendaDTO(String data, float total) {
        this.data = data;
        this.total = total;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
     public Object[] getLinhaTabela(){
        Object[] retorno = {data, String.valueOf(this.total)};
        return retorno;
    }
}
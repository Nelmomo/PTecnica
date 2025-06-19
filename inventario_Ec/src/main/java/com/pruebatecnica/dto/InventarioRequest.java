package com.pruebatecnica.dto;

import lombok.Data;

@Data
public class InventarioRequest {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private String type;
        private Attributes attributes;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Attributes getAttributes() {
            return attributes;
        }

        public void setAttributes(Attributes attributes) {
            this.attributes = attributes;
        }
    }

    public static class Attributes {
        private Long productos_id;
        private Integer cantidad;

        public Long getProductos_id() {
            return productos_id;
        }

        public void setProductos_id(Long productos_id) {
            this.productos_id = productos_id;
        }

        public Integer getCantidad() {
            return cantidad;
        }

        public void setCantidad(Integer cantidad) {
            this.cantidad = cantidad;
        }
    }
}


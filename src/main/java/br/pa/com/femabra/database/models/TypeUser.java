package br.pa.com.femabra.database.models;

public enum TypeUser {
    ADMIN(1,"ADMINISTRADOR"),SALESMAN(2,"VENDEDOR");

    private Integer id;

    private String name;


    TypeUser(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    TypeUser getUser(Integer id){
        for(TypeUser typeUser :values()){
            if(typeUser.id.intValue()==id.intValue()){
                return typeUser;
            }
        }
        return null;
    }
}


package com.co.ude.mintic.UdeaDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPersona extends JpaRepository <EntityPersona, Long> {
    //extendiendo esta interfaz podemos hacer CRUD
    //<objeto a manipular y tipo de dato>
    //El tipo de dato Long buscará siempre en el objeto a la variable que tenga la anotación @ID

}

package com.ec.entity;

import com.ec.entity.Doctor;
import com.ec.entity.Turno;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-12T17:53:36")
@StaticMetamodel(Especialidad.class)
public class Especialidad_ { 

    public static volatile SingularAttribute<Especialidad, String> codigoEspecialidad;
    public static volatile CollectionAttribute<Especialidad, Doctor> doctorCollection;
    public static volatile SingularAttribute<Especialidad, String> detalleEspecialidad;
    public static volatile SingularAttribute<Especialidad, Integer> idEspecialidad;
    public static volatile CollectionAttribute<Especialidad, Turno> turnoCollection;

}
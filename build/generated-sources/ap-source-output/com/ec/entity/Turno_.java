package com.ec.entity;

import com.ec.entity.Doctor;
import com.ec.entity.Especialidad;
import com.ec.entity.Paciente;
import com.ec.entity.TurnoPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-10T13:01:10")
@StaticMetamodel(Turno.class)
public class Turno_ { 

    public static volatile SingularAttribute<Turno, Doctor> doctor;
    public static volatile SingularAttribute<Turno, String> estado;
    public static volatile SingularAttribute<Turno, Paciente> paciente;
    public static volatile SingularAttribute<Turno, Date> fechahoraturno;
    public static volatile SingularAttribute<Turno, Especialidad> especialidad;
    public static volatile SingularAttribute<Turno, TurnoPK> turnoPK;

}
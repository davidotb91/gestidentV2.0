package com.ec.entity;

import com.ec.entity.DoctorPK;
import com.ec.entity.Especialidad;
import com.ec.entity.Turno;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-21T01:05:08")
@StaticMetamodel(Doctor.class)
public class Doctor_ { 

    public static volatile SingularAttribute<Doctor, String> ciDoctor;
    public static volatile SingularAttribute<Doctor, Integer> numConsultorioDoctor;
    public static volatile SingularAttribute<Doctor, String> emailDoctor;
    public static volatile SingularAttribute<Doctor, DoctorPK> doctorPK;
    public static volatile SingularAttribute<Doctor, Integer> celularDoctor;
    public static volatile CollectionAttribute<Doctor, Turno> turnoCollection;
    public static volatile SingularAttribute<Doctor, Integer> telefonoFijoDoctor;
    public static volatile SingularAttribute<Doctor, String> passwordDoctor;
    public static volatile SingularAttribute<Doctor, String> nombresDoctor;
    public static volatile SingularAttribute<Doctor, String> apellidosDoctor;
    public static volatile SingularAttribute<Doctor, Especialidad> especialidad;
    public static volatile SingularAttribute<Doctor, Date> fechaNacimientoDoctor;

}
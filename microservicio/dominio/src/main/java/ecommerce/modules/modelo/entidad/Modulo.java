package ecommerce.modules.modelo.entidad;

import ecommerce.dominio.ValidadorArgumento;

public class Modulo {
    private Long idModulo;
    private String name;
    private boolean edit;
    private boolean view;
    private boolean create;
    private boolean delete;

    public Modulo(Long idModulo, String name, boolean edit, boolean view, boolean create, boolean delete) {
        this.idModulo = idModulo;
        this.name = name;
        this.edit = edit;
        this.view = view;
        this.create = create;
        this.delete = delete;
    }

    public static Modulo reconstruir(Long idModulo, String name, boolean edit, boolean view, boolean create, boolean delete) {
        ValidadorArgumento.validarObligatorio(idModulo, "Debes ingresar un id del modulo");
        ValidadorArgumento.validarObligatorio(name, "Debes ingresar un nombre para reconstruir");
        ValidadorArgumento.validarObligatorio(edit, "Debes ingresar true o false para editar ");
        ValidadorArgumento.validarObligatorio(view, "Debes ingresar true o false para visualizar");
        ValidadorArgumento.validarObligatorio(create, "Debes ingresar true o false para crear");
        ValidadorArgumento.validarObligatorio(delete, "Debes ingresar true o false para borrar");
        return new Modulo(idModulo, name, edit, view, create, delete);
    }

    public Modulo(String name, boolean edit, boolean view, boolean create, boolean delete) {
        this.name = name;
        this.edit = edit;
        this.view = view;
        this.create = create;
        this.delete = delete;
    }

    public static Modulo crear(String name, boolean edit, boolean view, boolean create, boolean delete) {
        ValidadorArgumento.validarObligatorio(name, "Debes ingresar un nombre para reconstruir");
        ValidadorArgumento.validarObligatorio(edit, "Debes ingresar true o false para editar ");
        ValidadorArgumento.validarObligatorio(view, "Debes ingresar true o false para visualizar");
        ValidadorArgumento.validarObligatorio(create, "Debes ingresar true o false para crear");
        ValidadorArgumento.validarObligatorio(delete, "Debes ingresar true o false para borrar");
        return new Modulo(name, edit, view, create, delete);
    }

    public Long getIdModulo() {
        return idModulo;
    }

    public String getName() {
        return name;
    }

    public boolean isEdit() {
        return edit;
    }

    public boolean isView() {
        return view;
    }

    public boolean isCreate() {
        return create;
    }

    public boolean isDelete() {
        return delete;
    }
}

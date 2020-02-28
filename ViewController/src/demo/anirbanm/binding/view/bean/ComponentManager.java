package demo.anirbanm.binding.view.bean;

import demo.anirbanm.binding.view.utils.JSFUtils;

import java.io.Serializable;

import javax.faces.event.ValueChangeEvent;

public class ComponentManager implements Serializable {
    
    @SuppressWarnings("compatibility:-1936665264792808537")
    private static final long serialVersionUID = -5943266188615703813L;

    private String currentBinding = "DepartmentsVO1";
    
    public ComponentManager() {
        super();
    }

    public void onBindingChange(final ValueChangeEvent valueChangeEvent) {
        setCurrentBinding((String) valueChangeEvent.getNewValue());
    }

    public void setCurrentBinding(String currentBinding) {
        this.currentBinding = currentBinding;
    }

    public String getCurrentBinding() {
        return currentBinding;
    }
    
    public Object getSearchTableValue() {
        return JSFUtils.resolveExpression("#{bindings." + getCurrentBinding() + ".collectionModel}");
    }
    
    public Object[] getAttributeDefs() {
        return (Object[]) JSFUtils.resolveExpression("#{bindings." + getCurrentBinding() + "Iterator.attributeDefs}");
    }
}

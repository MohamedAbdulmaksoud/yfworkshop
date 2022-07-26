package com.yasserfahmy.workshop.views.form;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;
import com.yasserfahmy.workshop.data.entities.Customer;

public class CustomerForm extends FormLayout {
    Binder<Customer> binder = new BeanValidationBinder<>(Customer.class); //aware of bean validation annotations
    private Customer customer;

    TextField name = new TextField("Name");
    TextField phone = new TextField("Phone");
    TextField street = new TextField("Street");
    TextField city = new TextField("City");
    TextField vatNumber = new TextField("Vat Number");
    TextField customerCode = new TextField("Customer Code");
    //EmailField email = new EmailField("Email");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    public CustomerForm() {
        //Gives the component a CSS class name, so it can be styled later.
        addClassName("customer-form");
        binder.bindInstanceFields(this); //Match fields in Customer and CustomerForm based on their names

//        company.setItems(companies);
//        company.setItemLabelGenerator(Company::getName);

        //Adds all the UI components to the layout.
        add(name, phone, street, city, vatNumber, customerCode, createButtonsLayout());
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        save.addClickListener(event -> validateAndSave());
        delete.addClickListener(event -> fireEvent(new DeleteEvent(this, customer)));
        close.addClickListener(event -> fireEvent(new CloseEvent(this)));

        //Validates the form every time it changes. If it is invalid, it disables the save button to avoid invalid submissions.
        binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));
        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(customer); //Write the form contents back to the original contact
            fireEvent(new SaveEvent(this, customer)); //parent component handle the action
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    public void setContact(Customer customer){
        this.customer = customer; //Save a reference to the contact, to save the form values back into it later
        binder.readBean(customer); //copies the values from the contact to an internal model; that way no overwrite values if editing is cancelled.
    }
    /**
     * Common superclass for all the events.
     * Contains the customer that was edited or deleted.
     * */
    public static abstract class CustomerFormEvent extends ComponentEvent<CustomerForm> {
        private Customer customer;

        protected CustomerFormEvent(CustomerForm source, Customer customer) {
            super(source, false);
            this.customer = customer;
        }

        public Customer getContact() {
            return customer;
        }
    }
    public static class SaveEvent extends CustomerFormEvent {
        SaveEvent(CustomerForm source, Customer customer) {
            super(source, customer);
        }
    }
    public static class DeleteEvent extends CustomerFormEvent {
        DeleteEvent(CustomerForm source, Customer customer) {
            super(source, customer);
        }

    }
    public static class CloseEvent extends CustomerFormEvent {
        CloseEvent(CustomerForm source) {
            super(source, null);
        }
    }
    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener); //use Vaadin’s event bus to register the custom event types
    }
}

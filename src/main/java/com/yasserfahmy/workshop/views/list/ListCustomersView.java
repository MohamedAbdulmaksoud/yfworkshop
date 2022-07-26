package com.yasserfahmy.workshop.views.list;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.yasserfahmy.workshop.data.entities.Customer;
import com.yasserfahmy.workshop.data.service.CustomerService;
import com.yasserfahmy.workshop.views.form.CustomerForm;

@Route(value = "")
@PageTitle("Contacts | YF Workshop")
public class ListCustomersView extends VerticalLayout {

    Grid<Customer> grid = new Grid<>(Customer.class);
    TextField filterText = new TextField();
    CustomerForm form;
    CustomerService service;

    public ListCustomersView(CustomerService service) {
        this.service = service;
        addClassName("list-customers"); //css class name
        setSizeFull(); //same size as browser window
        configureGrid();
        configureForm();

        add(getToolbar(), getContent());
        updateList();
    }
    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, form);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, form);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }
    private void configureForm() {
        form = new CustomerForm();
        form.setWidth("25em");
    }
    private void configureGrid() {
        grid.addClassNames("customer-grid");
        grid.setSizeFull();
        grid.setColumns("name", "phone", "street","city", "customerCode", "vatNumber");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }
    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addContactButton = new Button("Add customer");
        HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }
    private void updateList() {
        grid.setItems(service.finaAllCustomers(filterText.getValue()));
    }
}

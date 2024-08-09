# BankAccountApplication

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 18.1.2.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.dev/tools/cli) page.

## Application Overview

### HomeComponent

This component is responsible for displaying a list of customers. It interacts with the `CustomerService` to fetch and display customer data. Users can update or delete customers using this component.

![HomeComponent Image Placeholder](#)

### CreateCustomerComponent

This component provides a form for creating new customers. It interacts with the `CustomerService` to submit customer data to the server and navigate to the home page upon successful creation.

![CreateCustomerComponent Image Placeholder](#)

### UpdateCustomerDialog

This component is used within the `HomeComponent` to open a dialog for updating customer information. It includes a form populated with the customer's existing data and allows users to submit updates.

![UpdateCustomerDialog Image Placeholder](#)

### FindByIdComponent

This component allows users to retrieve and display a customer by their ID. It interacts with the server to fetch customer details and displays them in the component.

![FindByIdComponent Image Placeholder](#)

### CreateAccountComponent

This component provides a form for creating new accounts, such as savings or checking accounts. It interacts with the `AccountService` to submit account data to the server and navigates to the account directory page upon successful creation.

![CreateAccountComponent Image Placeholder](#)

### AccountsdirectoryComponent

This component displays a directory of all accounts. It interacts with the `AccountService` to fetch and display account data, including account IDs, balances, and associated customer names.

![AccountsdirectoryComponent Image Placeholder](#)

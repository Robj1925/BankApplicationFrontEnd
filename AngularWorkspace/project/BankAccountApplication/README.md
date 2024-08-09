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

## Components

### HomeComponent

The `HomeComponent` displays a list of customers in a table format. It provides functionality to update and delete customers through a dialog.

- **Key Features**:
  - Fetches and displays customers.
  - Opens a dialog to update customer details.
  - Deletes a customer.

![HomeComponent Image](AngularWorkspace/project/BankAccountApplication/src/HomePage.png)

![HomeComponent Image](AngularWorkspace/project/BankAccountApplication/src/HomePage-UpdateDialog.png)

### UpdateCustomerDialog

The `UpdateCustomerDialog` component is used within a dialog to update customer information. It provides a form with fields for customer details and address.

- **Key Features**:
  - Displays a form for updating customer information.
  - Allows cancellation or submission of updates.

![UpdateCustomerDialog Image](path-to-image)

### CreateCustomerComponent

The `CreateCustomerComponent` handles the creation of new customers. It provides a form to input customer details and address, then posts this information to the backend.

- **Key Features**:
  - Provides a form to input new customer data.
  - Submits the data to create a new customer.

![CreateCustomerComponent Image](path-to-image)

### FindByIdComponent

The `FindByIdComponent` retrieves and displays customer information based on a given ID.

- **Key Features**:
  - Retrieves customer information by ID.
  - Displays the customer data.

![FindByIdComponent Image](path-to-image)

### CreateAccountComponent

The `CreateAccountComponent` manages the creation of new accounts. It includes a form to input account details and specifies account type with additional fields for savings or checking accounts.

- **Key Features**:
  - Provides a form to input account details.
  - Allows for the creation of savings or checking accounts with specific fields.

![CreateAccountComponent Image](path-to-image)

### AccountsdirectoryComponent

The `AccountsdirectoryComponent` displays a list of all accounts, showing their ID, balance, and associated customer name.

- **Key Features**:
  - Displays a table of all accounts.
  - Allows navigation to create new accounts.

![AccountsdirectoryComponent Image](path-to-image)

## Services

### CustomerService

The `CustomerService` handles HTTP requests related to customer data, including creating, fetching, updating, and deleting customers.

- **Key Methods**:
  - `post(customerForm: any)`: Create a new customer.
  - `getCustomerById(id: number)`: Fetch customer by ID.
  - `getAllCustomers()`: Fetch all customers.
  - `updateCustomer(updatedCustomer: any)`: Update customer information.
  - `deleteCustomer(customer: any)`: Delete a customer.

![CustomerService Image](path-to-image)

### AccountService

The `AccountService` manages HTTP requests for account-related operations, including creating and fetching accounts.

- **Key Methods**:
  - `post(account: any)`: Create a new account.
  - `getAllAccounts()`: Fetch all accounts.

![AccountService Image](path-to-image)

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.dev/tools/cli) page.

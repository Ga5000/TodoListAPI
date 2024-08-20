# Todo List API

<a href="https://github.com/Ga5000">![Made with](https://img.shields.io/badge/Spring-green)</a>
<a href="https://github.com/Ga5000">![Made with](https://img.shields.io/badge/Java-red)</a>
<a href="https://github.com/Ga5000">![Made with](https://img.shields.io/badge/Maven-red)</a>
<a href="https://github.com/Ga5000">![Made with](https://img.shields.io/badge/MySQL-blue)</a>

## Endpoints

### Create Todo

- **URL:** `/todos`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "title": "Sample Todo",
        "description": "This is a sample todo description",
        "finished": false,
        "priority": 1,
        "expireDate": "2024-08-23T15:00:00"
    }
    ```
- **Response:**
  - **Status:** `201 Created`
  - **Body:** `"Todo created successfully"`
  - **Error Response:** `400 Bad Request` for validation errors or missing required fields.

### Get All Todos

- **URL:** `/todos`
- **Method:** `GET`
- **Response:**
  - **Status:** `200 OK`
  - **Body:**
    ```json
    [
        {
            "id": 1,
            "title": "Sample Todo",
            "description": "This is a sample todo description",
            "finished": false,
            "priority": 1,
            "creationDate": "2023-07-25T10:00:00",
            "expireDate": "2024-08-23T15:00:00",
            "expired": false
        }
    ]
    ```

### Update Todo

- **URL:** `/todos/{id}`
- **Method:** `PUT`
- **Request Body:**
    ```json
    {
        "title": "Updated Todo",
        "description": "This is an updated todo description",
        "priority": 2,
        "expireDate": "2024-08-21T20:00:00"
    }
    ```
- **Response:**
  - **Status:** `200 OK`
  - **Body:** `"Todo updated successfully"`
  - **Error Response:** `404 Not Found` if the Todo item with the specified ID is not found, or `400 Bad Request` for validation errors.

### Delete Todo

- **URL:** `/todos/{id}`
- **Method:** `DELETE`
- **Path Variable:**
  - `id` (Long) - The ID of the Todo to delete.
- **Response:**
  - **Status:** `204 No Content`
  - **Body:** `"Todo deleted successfully"`
  - **Error Response:** `404 Not Found` if the Todo item with the specified ID is not found.

### Get Priority Todos

- **URL:** `/todos/priority`
- **Method:** `GET`
- **Response:**
  - **Status:** `200 OK`
  - **Body:**
    ```json
    [
        {
            "id": 1,
            "title": "Sample Todo",
            "description": "This is a sample todo description",
            "finished": false,
            "priority": 1,
            "creationDate": "2023-07-25T10:00:00",
            "expireDate": "2024-08-23T15:00:00",
            "expired": false
        }
    ]
    ```
  - **Error Response:** `204 No Content` if no todos with priority equal to 1 are found.

## Running the API

To run the TodoList API locally:

1. Clone the repository:
    ```sh
    git clone https://github.com/Ga5000/TodoListAPI
    ```
2. Navigate to the project directory:
    ```sh
    cd TodoListAPI
    ```
3. Build and run the application (assuming you're using Maven):
    ```sh
    ./mvnw spring-boot:run
    ```
4. The API should be accessible at [http://localhost:8080](http://localhost:8080).

## Running Tests

To run the tests for this API, you can use the following command:

```sh
./mvnw test

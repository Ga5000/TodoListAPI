# Todo List API


<a href="https://github.com/Ga5000">![Made with](https://img.shields.io/badge/Spring-green)</a>
<a href="https://github.com/Ga5000">![Made with](https://img.shields.io/badge/Java-red)</a>
<a href="https://github.com/Ga5000">![Made with](https://img.shields.io/badge/Maven-red)</a>
<a href="https://github.com/Ga5000">![Made with](https://img.shields.io/badge/MySQL-blue)</a>


## Endpoints

### Create Todo

- **URL:** `/todos/create`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "title": "Sample Todo",
        "description": "This is a sample todo description",
        "finished": false,
        "priority": 1
    }
    ```
- **Response:**
    - **Status:** `201 Created`
    - **Body:** `"Todo created successfully"`

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
            "creationDate": "2023-07-25T10:00:00"
        },
        ...
    ]
    ```

### Update Todo

- **URL:** `/todos/update`
- **Method:** `PUT`
- **Request Body:**
    ```json
    {
        "id": 1,
        "title": "Updated Todo",
        "description": "This is an updated todo description",
        "finished": true,
        "priority": 2,
        "creationDate": "2023-07-25T10:00:00"
    }
    ```
- **Response:**
    - **Status:** `200 OK`
    - **Body:** `"Todo updated successfully"`

### Delete Todo

- **URL:** `/todos/delete/{id}`
- **Method:** `DELETE`
- **Path Variable:**
    - `id` (Long) - The ID of the Todo to delete.
- **Response:**
    - **Status:** `200 OK`
    - **Body:** `"Todo deleted successfully"`

## Running Tests

To run the tests for this API, you can use the following commands:

```sh
./mvnw test



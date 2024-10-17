import axios from "axios";

const url = "http://localhost:8080/api/auth/";

export const signup = (firstName, lastName,  email, password) => 
    axios.post(url + "signup",{firstName, 
        lastName, 
        email, 
        password
    });


export function login(email, password) {
    return axios.post(url + "signin", {
        email,
        password
    })
    .then(response => {
        if (response.data.accessToken) {
            localStorage.setItem("user", JSON.stringify(response.data));
        }

        return response.data;
    });
}

export const logout = () => localStorage.removeItem("user");
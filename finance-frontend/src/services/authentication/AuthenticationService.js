import axios from "axios";

const url = "http://localhost:8080/api/auth/";

export const signup = (firstName, lastName,  email, password) => 
    axios.post(url + "signup",{firstName, 
        lastName, 
        email, 
        password
    });


export function login(email, password) {
    return axios.post(url + "login", {
        email,
        password
    })
    .then(response => {
        if (response.data.accessToken) {
            localStorage.setItem("user", JSON.stringify(response.data));
            return true;
        }

        return false;
    });
}

export const logout = () => localStorage.removeItem("user");
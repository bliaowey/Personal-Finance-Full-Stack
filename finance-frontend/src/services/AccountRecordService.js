import axios from "axios"
import authHeader from "./authentication/AuthenticationHeader";

const REST_API_BASE_URL = 'http://localhost:8080/api/account-records';

export const listAccountRecords = () => axios.get(REST_API_BASE_URL, authHeader);

export const listLastFiveRecords = () => axios.get(REST_API_BASE_URL + '/recent-transactions', authHeader);

export const addAccountRecord = (accountType,
                                date,
                                value,
                                categoryType,
                                comments
) => axios.post(REST_API_BASE_URL, null, {params: {
    accountType: accountType,
    date: date,
    value: value,
    categoryType: categoryType,
    comments: comments
}});

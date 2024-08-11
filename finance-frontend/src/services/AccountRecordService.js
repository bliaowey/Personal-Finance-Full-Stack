import axios from "axios"

const REST_API_BASE_URL = 'http://localhost:8080/api/account-records';

export const listAccountRecords = () => axios.get(REST_API_BASE_URL);

export const listLastFiveRecords = () => axios.get(REST_API_BASE_URL + '/recent-transactions')

export const addAccountRecord = (accountRecord) => axios.post(REST_API_BASE_URL, accountRecord);

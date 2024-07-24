import React, { useState, useEffect } from 'react'
import { listAccountRecords } from '../services/AccountRecordService';

const ListAccountRecordComponent = () => {

    const [accountRecords, setAccountRecords] = useState([]);
    useEffect(() =>{
        listAccountRecords().then((response) => {
            setAccountRecords(response.data);
        }).catch(error => {
            console.error(error);
        })
    }, []);

  return (
    <div  className='container'>
        <h2 className='text-center'>List of Account Records</h2>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Account Record ID</th>
                    <th>Account Type</th>
                    <th>Date</th>
                    <th>Value</th>
                    <th>Category ID</th>
                    <th>Category Type</th>
                    <th>Comments</th>
                </tr>
            </thead>
            <tbody>
                {
                    accountRecords.map(accountRecord =>
                        <tr key={accountRecord.id}>
                            <td>{accountRecord.id}</td>
                            <td>{accountRecord.accountType}</td>
                            <td>{accountRecord.date}</td>
                            <td>{accountRecord.value}</td>
                            <td>{accountRecord.categoryId}</td>
                            <td>{accountRecord.categoryType}</td>
                            <td>{accountRecord.comments}</td>
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListAccountRecordComponent
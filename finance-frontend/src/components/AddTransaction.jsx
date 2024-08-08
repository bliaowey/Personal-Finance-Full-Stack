import * as React from 'react';
import { useState } from 'react';
import Title from './Title';
import { Container } from '@mui/material';
import { addAccountRecord } from '../services/AccountRecordService';

function preventDefault(event) {
  event.preventDefault();
}

export default function AddTransaction() {
    const [accountType, setAccountType] = useState('');
    const [date, setDate] = useState('');
    const [value, setValue] = useState('');
    const [categoryId, setCategoryId] = useState('');
    const [categoryType, setCategoryType] = useState('');
    const [comments, setComments] = useState('');

    function saveAccountRecord(e) {
        e.preventDefault();

        const accountRecord = {accountType, date, value, categoryId, categoryType, comments};
        console.log(accountRecord);

        addAccountRecord(accountRecord).then((response) => {
            console.log(response.data);
        });
    }

    return (
        <React.Fragment>
            <Container maxWidth="lg" sx={{ mt: 10, mb: 4 }}>
                <div className='row'>
                    <div className='card'>
                        <Title>Add Transaction</Title>
                        <div className='card-body'>
                            <form>
                                <div className='form-group mb-2'>
                                    <label className='form-label'>Account Type</label>
                                    <input
                                        type='number'
                                        min="1"
                                        placeholder='Enter Account Type'
                                        value={accountType}
                                        className='form-control'
                                        onChange={(e) => setAccountType(e.target.value)}
                                    >
                                    </input>
                                </div>
                                <div className='form-group mb-2'>
                                    <label className='form-label'>Date</label>
                                    <input
                                        type='date'
                                        placeholder='Enter Date'
                                        value={date}
                                        className='form-control'
                                        onChange={(e) => setDate(e.target.value)}
                                    >
                                    </input>
                                </div>
                                <div className='form-group mb-2'>
                                    <label className='form-label'>Value</label>
                                    <input
                                        type='number'
                                        min="1"
                                        placeholder='Enter a Value'
                                        value={value}
                                        className='form-control'
                                        onChange={(e) => setValue(e.target.value)}
                                    >
                                    </input>
                                </div>
                                <div className='form-group mb-2'>
                                    <label className='form-label'>Category ID</label>
                                    <input
                                        type='number'
                                        min="1"
                                        placeholder='Enter Category ID'
                                        value={categoryId}
                                        className='form-control'
                                        onChange={(e) => setCategoryId(e.target.value)}
                                    >
                                    </input>
                                </div>
                                <div className='form-group mb-2'>
                                    <label className='form-label'>Category Type</label>
                                    <input
                                        type='number'
                                        min="1"
                                        placeholder='Enter Category Type'
                                        value={categoryType}
                                        className='form-control'
                                        onChange={(e) => setCategoryType(e.target.value)}
                                    >
                                    </input>
                                </div>
                                <div className='form-group mb-2'>
                                    <label className='form-label'>Comments</label>
                                    <input
                                        type='text'
                                        placeholder='Enter Comments'
                                        value={comments}
                                        className='form-control'
                                        onChange={(e) => setComments(e.target.value)}
                                    >
                                    </input>
                                </div>
                            </form>
                        </div>
                        <button className='btn btn-primary mb-2' onClick={saveAccountRecord}>Add</button>
                    </div>
                </div>
            </Container>
        </React.Fragment>
    );
}
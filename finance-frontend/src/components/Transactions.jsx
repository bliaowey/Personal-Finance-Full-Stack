import * as React from 'react';
import { useState, useEffect } from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Title from './Title';
import { Container } from '@mui/material';
import { listAccountRecords } from '../services/AccountRecordService';
import { AppBar } from '@mui/material';


export default function Transactions() {
    const [accountRecords, setAccountRecords] = useState([]);
    useEffect(() =>{
        listAccountRecords().then((response) => {
            setAccountRecords(response.data);
        }).catch(error => {
            console.error(error);
        })
    }, []);
  return (
    <React.Fragment>
      <Container maxWidth="lg" sx={{ mt: 10, mb: 4 }}>
        <div className='card'>
          <Title>All Transactions</Title>
            <Table size="big">
              <TableHead>
                <TableRow>
                  <th>Account Record ID</th>
                  <th>Account Type</th>
                  <th>Date</th>
                  <th>Value</th>
                  <th>Category ID</th>
                  <th>Category Type</th>
                  <th>Comments</th>
                </TableRow>
              </TableHead>
              <TableBody>
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
              </TableBody>
            </Table>
          </div>
        </Container>
    </React.Fragment>
  );
}
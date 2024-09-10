import * as React from 'react';
import { useState, useEffect } from 'react';
import Link from '@mui/material/Link';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Title from './Title';
import { listLastFiveRecords } from '../services/AccountRecordService';

function preventDefault(event) {
  event.preventDefault();
}

export default function RecentTransactions() {
    const [accountRecords, setAccountRecords] = useState([]);
    useEffect(() =>{
        listLastFiveRecords().then((response) => {
            setAccountRecords(response.data);
        }).catch(error => {
            console.error(error);
        })
    }, []);
  return (
    <React.Fragment>
      <Title>Recent Transactions</Title>
      <Table size="small">
        <TableHead>
          <TableRow>
            <th>Account Record ID</th>
            <th>Account Type</th>
            <th>Date</th>
            <th>Value</th>
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
                    <td>{accountRecord.categoryType}</td>
                    <td>{accountRecord.comments}</td>
                </tr>
                )
            }
        </TableBody>
      </Table>
      <Link color="primary" href="/all-transaction" onClick={preventDefault} sx={{ mt: 3 }}>
        See more orders
      </Link>
    </React.Fragment>
  );
}
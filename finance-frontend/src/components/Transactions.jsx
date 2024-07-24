import * as React from 'react';
import { useState, useEffect } from 'react';
import Link from '@mui/material/Link';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Title from './Title';
import { listAccountRecords } from '../services/AccountRecordService';

// Generate Order Data
function createData(id, date, name, shipTo, paymentMethod, amount) {
  return { id, date, name, shipTo, paymentMethod, amount };
}

/*const rows = [
  createData(
    0,
    '16 Mar, 2019',
    'Elvis Presley',
    'Tupelo, MS',
    'VISA ⠀•••• 3719',
    312.44,
  ),
  createData(
    1,
    '16 Mar, 2019',
    'Paul McCartney',
    'London, UK',
    'VISA ⠀•••• 2574',
    866.99,
  ),
  createData(2, '16 Mar, 2019', 'Tom Scholz', 'Boston, MA', 'MC ⠀•••• 1253', 100.81),
  createData(
    3,
    '16 Mar, 2019',
    'Michael Jackson',
    'Gary, IN',
    'AMEX ⠀•••• 2000',
    654.39,
  ),
  createData(
    4,
    '15 Mar, 2019',
    'Bruce Springsteen',
    'Long Branch, NJ',
    'VISA ⠀•••• 5919',
    212.79,
  ),
]; */


function preventDefault(event) {
  event.preventDefault();
}

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
      <Title>Recent Orders</Title>
      <Table size="small">
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
      <Link color="primary" href="#" onClick={preventDefault} sx={{ mt: 3 }}>
        See more orders
      </Link>
    </React.Fragment>
  );
}
import * as React from 'react';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Container from '@mui/material/Container';
import Grid from '@mui/material/Grid';
import Paper from '@mui/material/Paper';
import Chart from './Chart';
import RecentTransactions from './RecentTransactions';

export default function HomePage() {
    return(
        <Box
            component="main"
            sx={{
            backgroundColor: (theme) =>
                theme.palette.mode === 'light'
                ? theme.palette.grey[100]
                : theme.palette.grey[900],
                flexGrow: 1,
                height: '100vh',
                overflow: 'auto',
            }}
        >
            <Toolbar />
                <Container maxWidth="lg" sx={{ mt: 4, mb: 4 }}>
                <Grid container spacing={3}>
                    {/* Chart */}
                    <Grid item xs={12} md={8} lg={9}>
                        <Paper
                            sx={{
                                p: 2,
                                display: 'flex',
                                flexDirection: 'column',
                                height: 240,
                            }}
                            >
                            <Chart />
                        </Paper>
                    </Grid>
                    {/* Flex box on the top right */}
                    <Grid item xs={12} md={4} lg={3}>
                        <Paper
                        sx={{
                            p: 2,
                            display: 'flex',
                            flexDirection: 'column',
                            height: 240,
                        }}
                        >
                        </Paper>
                    </Grid>
                    {/* Summary of the last 5 transactions */}
                    <Grid item xs={12}>
                        <Paper sx={{ p: 2, display: 'flex', flexDirection: 'column' }}>
                        <RecentTransactions />
                        </Paper>
                    </Grid>
                    </Grid>
            </Container>
        </Box>
    );
}

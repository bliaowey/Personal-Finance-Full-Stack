import * as React from 'react';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';

/* I SEPARATED THE HEADER FROM THE DASHBOARD
THE PROBLEM HERE IS THAT toggleDrawer  IS NOT DEFINED. IT IS USED IN Dashboard.jsx BUT NEVER
DEFINED, AND IT WORKS THERE. I LOOKED INTO @mui BUT I COULDN'T FIND HOW TO USE IT.
 */

export default function Header() {
    return (
        <Toolbar
            sx={{
              pr: '24px', // keep right padding when drawer closed
            }}
          >
            <IconButton
              edge="start"
              color="inherit"
              aria-label="open drawer"
              //onClick={toggleDrawer}
              //ERROR: toggleDrawer NOT DEFINED
              sx={{
                marginRight: '36px',
                ...(open && { display: 'none' }),
              }}
            >
              <MenuIcon />
            </IconButton>
            <Typography
              component="h1"
              variant="h6"
              color="inherit"
              noWrap
              sx={{ flexGrow: 1 }}
            >
              Dashboard
            </Typography>
          </Toolbar>
    );
}
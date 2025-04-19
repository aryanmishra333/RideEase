import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useSelector } from 'react-redux';
import {
  Box,
  Typography,
  Button,
  Paper,
  Grid,
  Card,
  CardContent,
  CardActions,
} from '@mui/material';
import { DirectionsCar, History, Person } from '@mui/icons-material';

export default function Dashboard() {
  const navigate = useNavigate();
  const user = useSelector((state) => state.auth.user);

  return (
    <Box>
      <Typography variant="h4" gutterBottom>
        Welcome, {user?.firstName}!
      </Typography>
      <Grid container spacing={3}>
        <Grid item xs={12} md={4}>
          <Card>
            <CardContent>
              <DirectionsCar sx={{ fontSize: 40, color: 'primary.main' }} />
              <Typography variant="h6" component="div" sx={{ mt: 2 }}>
                Book a Ride
              </Typography>
              <Typography variant="body2" color="text.secondary">
                Find and book your next ride with ease
              </Typography>
            </CardContent>
            <CardActions>
              <Button
                size="small"
                onClick={() => navigate('/book-ride')}
              >
                Book Now
              </Button>
            </CardActions>
          </Card>
        </Grid>
        <Grid item xs={12} md={4}>
          <Card>
            <CardContent>
              <History sx={{ fontSize: 40, color: 'primary.main' }} />
              <Typography variant="h6" component="div" sx={{ mt: 2 }}>
                Ride History
              </Typography>
              <Typography variant="body2" color="text.secondary">
                View your past rides and receipts
              </Typography>
            </CardContent>
            <CardActions>
              <Button
                size="small"
                onClick={() => navigate('/ride-history')}
              >
                View History
              </Button>
            </CardActions>
          </Card>
        </Grid>
        <Grid item xs={12} md={4}>
          <Card>
            <CardContent>
              <Person sx={{ fontSize: 40, color: 'primary.main' }} />
              <Typography variant="h6" component="div" sx={{ mt: 2 }}>
                Profile
              </Typography>
              <Typography variant="body2" color="text.secondary">
                Manage your account settings
              </Typography>
            </CardContent>
            <CardActions>
              <Button
                size="small"
                onClick={() => navigate('/profile')}
              >
                View Profile
              </Button>
            </CardActions>
          </Card>
        </Grid>
      </Grid>
    </Box>
  );
} 
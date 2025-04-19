import { useState } from 'react';
import {
  Box,
  Typography,
  TextField,
  Button,
  Paper,
  Grid,
  MenuItem,
} from '@mui/material';

export default function BookRide() {
  const [formData, setFormData] = useState({
    pickupLocation: '',
    dropoffLocation: '',
    vehicleType: 'SEDAN',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    // TODO: Implement ride booking logic
    console.log('Booking ride with:', formData);
  };

  return (
    <Box>
      <Typography variant="h4" gutterBottom>
        Book a Ride
      </Typography>
      <Paper
        elevation={3}
        sx={{
          padding: 4,
          maxWidth: 600,
          margin: '0 auto',
        }}
      >
        <form onSubmit={handleSubmit}>
          <Grid container spacing={3}>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="pickupLocation"
                label="Pickup Location"
                name="pickupLocation"
                value={formData.pickupLocation}
                onChange={handleChange}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="dropoffLocation"
                label="Dropoff Location"
                name="dropoffLocation"
                value={formData.dropoffLocation}
                onChange={handleChange}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                select
                id="vehicleType"
                label="Vehicle Type"
                name="vehicleType"
                value={formData.vehicleType}
                onChange={handleChange}
              >
                <MenuItem value="SEDAN">Sedan</MenuItem>
                <MenuItem value="SUV">SUV</MenuItem>
                <MenuItem value="LUXURY">Luxury</MenuItem>
              </TextField>
            </Grid>
            <Grid item xs={12}>
              <Button
                type="submit"
                fullWidth
                variant="contained"
                size="large"
              >
                Find Rides
              </Button>
            </Grid>
          </Grid>
        </form>
      </Paper>
    </Box>
  );
} 
import { useState, useEffect } from 'react';
import {
  Box,
  Typography,
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Chip,
} from '@mui/material';

export default function RideHistory() {
  const [rides, setRides] = useState([]);

  useEffect(() => {
    // TODO: Fetch ride history from API
    const mockRides = [
      {
        id: 1,
        pickupLocation: '123 Main St',
        dropoffLocation: '456 Park Ave',
        fare: 25.50,
        status: 'COMPLETED',
        date: '2024-04-19',
      },
      {
        id: 2,
        pickupLocation: '789 Broadway',
        dropoffLocation: '321 Market St',
        fare: 18.75,
        status: 'CANCELLED',
        date: '2024-04-18',
      },
    ];
    setRides(mockRides);
  }, []);

  const getStatusColor = (status) => {
    switch (status) {
      case 'COMPLETED':
        return 'success';
      case 'CANCELLED':
        return 'error';
      case 'IN_PROGRESS':
        return 'warning';
      default:
        return 'default';
    }
  };

  return (
    <Box>
      <Typography variant="h4" gutterBottom>
        Ride History
      </Typography>
      <TableContainer component={Paper}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>Date</TableCell>
              <TableCell>Pickup Location</TableCell>
              <TableCell>Dropoff Location</TableCell>
              <TableCell>Fare</TableCell>
              <TableCell>Status</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {rides.map((ride) => (
              <TableRow key={ride.id}>
                <TableCell>{ride.date}</TableCell>
                <TableCell>{ride.pickupLocation}</TableCell>
                <TableCell>{ride.dropoffLocation}</TableCell>
                <TableCell>${ride.fare.toFixed(2)}</TableCell>
                <TableCell>
                  <Chip
                    label={ride.status}
                    color={getStatusColor(ride.status)}
                  />
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </Box>
  );
} 
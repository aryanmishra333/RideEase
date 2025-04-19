import axios from 'axios';

const API_URL = 'http://localhost:8080/api';

export const login = async (email, password) => {
  try {
    const response = await axios.post(`${API_URL}/users/authenticate`, {
      email,
      password,
    });
    return response.data;
  } catch (error) {
    throw error.response?.data || error.message;
  }
};

export const register = async (userData) => {
  try {
    const response = await axios.post(`${API_URL}/users/register`, userData);
    return response.data;
  } catch (error) {
    throw error.response?.data || error.message;
  }
};

export const logout = () => {
  // Clear any stored tokens or user data
  localStorage.removeItem('token');
  localStorage.removeItem('user');
}; 
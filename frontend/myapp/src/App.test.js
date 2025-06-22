import { render, screen } from '@testing-library/react';
import App from './App';

test('renders fetch button', () => {
  render(<App />);
  const buttonElement = screen.getByText(/데이터 가져오기/i);
  expect(buttonElement).toBeInTheDocument();
});

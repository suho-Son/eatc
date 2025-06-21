import { render, screen } from '@testing-library/react';
import App from './App';

test('사용자 목록 제목이 화면에 표시된다', () => {
  render(<App />);
  const heading = screen.getByText(/사용자 목록/i);
  expect(heading).toBeInTheDocument();
});

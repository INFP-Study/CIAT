import React from 'react';
import styled from 'styled-components';
import { Button } from 'antd';
import {
  ERROR_CODE,
  ERROR_CONTENT_F,
  ERROR_CONTENT_S,
  HOME,
} from '../../constants';
import { theme } from '../../style/theme';
import { Link } from 'react-router-dom';
import { MAIN_URL } from '../../constants/urls';

const Wrapper = styled.div`
  width: 100%;
  height: 700px;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const InnerWrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 700px;
`;

const GoHome = styled(Button)`
  width: 130px;
  height: 40px;
`;

const Box = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  font-weight: ${theme.weightBold};
`;

const ErrorContent = styled.div`
  font-family: ${theme.fontBasic};
  font-size: ${theme.fontSizeTitle02};
  font-weight: ${theme.weightMid};
  text-align: center;
  line-height: 40px;
`;

const Logo = styled.img`
  width: 140px;
`;

function NotFound() {
  return (
    <Wrapper>
      <InnerWrapper style={{ paddingTop: '100px' }}>
        <Logo className="404image" alt="404logo" src="image/404logo.png" />
        <Box
          style={{
            textShadow:
              '-1px 0 #7ea592, 0 1px #7ea592, 1px 0 #7ea592, 0 -1px #7ea592',
            fontSize: '100px',
            color: '#fff',
          }}
        >
          {ERROR_CODE}
        </Box>
        <Box>
          <ErrorContent>
            {ERROR_CONTENT_F}
            <br />
            {ERROR_CONTENT_S}
          </ErrorContent>
        </Box>
        <Box style={{ paddingTop: '50px' }}>
          <Link to={MAIN_URL}>
            <GoHome type="primary">{HOME}</GoHome>
          </Link>
        </Box>
      </InnerWrapper>
    </Wrapper>
  );
}

export default NotFound;

import React from 'react';
import { Layout } from 'antd';
import { Content } from 'antd/lib/layout/layout';
import SiteHeader from './header';
import SiteFooter from './footer';
import Nav from './nav';
import styled from 'styled-components';
import { theme } from '../../../constants/theme';
import Category from './category';
import { FEED_URL } from '../../../constants/urls';

const Wapper = styled(Layout)`
  display: flex;
  flex-direction: row;
`;

const ContentWrapper = styled(Content)`
  margin: 24px 16px 0px;
`;
const ContentInner = styled.div`
  padding: 24px;
  min-height: 80vh;
  background: ${theme.colorWhite};
  font-size: ${theme.fontSizeBody02};
  font-family: ${theme.fontBasic};
`;

function SiteLayout({ children }) {
  return (
    <Wapper>
      <Layout style={{ minHeight: '100vh', flexDirection: 'row' }}>
        <Nav />
        {location.pathname.includes(FEED_URL) && <Category />}
      </Layout>
      <Layout style={{ background: theme.colorWhite, width: '100%' }}>
        <SiteHeader />
        <ContentWrapper>
          <ContentInner>{children}</ContentInner>
        </ContentWrapper>
        <SiteFooter />
      </Layout>
    </Wapper>
  );
}

export default SiteLayout;

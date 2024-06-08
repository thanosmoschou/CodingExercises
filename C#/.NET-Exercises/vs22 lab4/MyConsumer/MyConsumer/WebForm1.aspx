<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="MyConsumer.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:TextBox ID="tbMyValue" runat="server"></asp:TextBox>
            <asp:Label ID="Label1" runat="server" Text="Price"></asp:Label>
            <br />
            <br />
            <asp:TextBox ID="tbMyTotal" runat="server"></asp:TextBox>
            <asp:Label ID="Label2" runat="server" Text="Sinolo"></asp:Label>
            <br />
            <br />
            <asp:Button ID="btnCalculate" runat="server" OnClick="btnCalculate_Click" Text="Calculate" />
            <br />
            <br />
            <asp:Label ID="lblPercentageLabel" runat="server" Text="‘= ποσοστό που υπολογίστηκε’ " Visible="False"></asp:Label>
            <br />
            <br />
            <asp:Label ID="lblServerTime" runat="server"></asp:Label>
&nbsp;<asp:Label ID="Label3" runat="server" Text="= η ώρα στον server"></asp:Label>
        </div>
    </form>
</body>
</html>
